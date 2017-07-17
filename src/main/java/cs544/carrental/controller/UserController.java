package cs544.carrental.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cs544.carrental.domain.Account;
import cs544.carrental.domain.AccountType;
import cs544.carrental.domain.Address;
import cs544.carrental.domain.Person;
import cs544.carrental.service.AccountService;
import cs544.carrental.service.PersonService;



@Controller
@RequestMapping("/user/")
// @SessionAttributes("person")
public class UserController {
	@Autowired
	private PersonService personService;
	@Autowired
	private AccountService accountService;

	


	//for the purpose redirecting user or admin
	@RequestMapping(value = "/homeRedicrect", method = RequestMethod.GET)
	public String home(Model model, HttpSession session) {
		Person p= (Person) session.getAttribute("person");
		if(p.getAccount().getAccountType().equals(AccountType.ADMIN))
		  return "redirect:/user/adminHomePage";
		else
			 return "redirect:/user/userHomePage";
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String listUsers(Model model) {

		model.addAttribute("personList", personService.findAll());
		return "/users/user/listUser";
	}

	@RequestMapping(value = "/searchUser", method = RequestMethod.POST)
	public String searchUsers(@RequestParam("userName") String userName, Model model) {
		if (userName == "") {
			return "redirect:/user/users";
		}
		model.addAttribute("personList", personService.findByUsername(userName));
		return "/users/user/listUser";
	}

	@RequestMapping(value = "update/{PersonId}")
	public String update(@PathVariable Integer PersonId, Model model) {
		Person person = this.personService.findOne(PersonId);
		Address address = person.getAddress();
		Account account = person.getAccount();
		model.addAttribute("person", person);
		model.addAttribute("address", address);
		model.addAttribute("account", account);
		return "/users/user/updateUser";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(@Valid Person person, BindingResult result, Address address, Account account, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("person", person);
			model.addAttribute("address", address);
			model.addAttribute("account", account);
			return "/users/user/updateUser";
		} else {
			account.setActive(true);
			if(account.getAccountType().equals(AccountType.ADMIN)){
				account.setAccountType(AccountType.ADMIN);
			}
			else{
				account.setAccountType(AccountType.CUSTOMER);
			}
			String password = accountService.MD5(account.getPassword());
			account.setPassword(password);
			accountService.update(account);

			System.out.println(person.toString());
			// personService.updatePerson(person,account.getAccountId());
			person.setAddress(address);
			person.setAccount(account);
			System.out.println(account.toString());
			System.out.println(address.toString());
			System.out.println(account.getAccountId());
			//personService.updatePerson(person, account.getAccountId());
			personService.update(person);
			return "redirect:/user/users";
		}
	}

	/*
	 * //RESTfull service
	 * 
	 * @RequestMapping(value = "back", method = RequestMethod.GET )
	 * public @ResponseBody String back(Model data) { return
	 * "users/admin/HomePage"; //System.out.println("deleted"); // return
	 * "redirect:/users"; }
	 */

	/*@RequestMapping(value = "delete/{PersonId}", method = RequestMethod.GET)
	public @ResponseBody String delete(@PathVariable Integer PersonId, Model data) {
		Integer AccountId = personService.find(PersonId).getAccount().getAccountId();
		personService.deletePerson(PersonId);
		accountService.deleteAccount(AccountId);
		return "redirect:"+"/user/users";
		// System.out.println("deleted");
		// return "redirect:/users";
	}*/
	@RequestMapping(value = "delete/{PersonId}", method = RequestMethod.GET)
	public  String delete(@PathVariable Integer PersonId, Model data) {
		long AccountId = personService.findOne(PersonId).getAccount().getAccountId();
		personService.delete(PersonId);
		accountService.delete(AccountId);
		return "redirect:"+"/user/users"; 
	}

	@RequestMapping(value = "userHomePage", method = RequestMethod.GET)
	public String userHomePage(Model model, Principal principal, HttpSession session) {
		System.out.println("sesssssssssssssssssssssssssssss: " + principal.getName());
		Account acc = accountService.findByUsername(principal.getName());
		session.setAttribute("person", personService.getLoggedInPersonByAccount(acc));
		// model.addAttribute("user", "sample name");
		return "users/user/userHomePage";
	}
	@RequestMapping(value = "adminHomePage", method = RequestMethod.GET)
	public String adminHomePage(Model model, Principal principal, HttpSession session) {

		Account acc = accountService.findByUsername(principal.getName());
		session.setAttribute("person", personService.getLoggedInPersonByAccount(acc));
		return "users//admin/HomePage";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}

	

}
