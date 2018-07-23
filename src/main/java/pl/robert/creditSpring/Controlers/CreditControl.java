package pl.robert.creditSpring.Controlers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.robert.creditSpring.modules.CreditClass;

@Controller
public class CreditControl {

    //@GetMapping bez obiektu/klasy CreditClass ale z templatka mainCredit
    //@GetMapping("/mainCredit")
    //    public String showMainCredit() {
    //        return "mainCredit";
    //    }

    @GetMapping("/mainCredit")
    public String showMainCredit(Model model) {
        model.addAttribute("creditClass", new CreditClass());
        return "mainCredit";
    }

@PostMapping("/mainCredit")
    public String fuckKnowsPostMappingString (@ModelAttribute ("creditClass") CreditClass creditClass,Model model){
    System.out.println(creditClass);
    if((creditClass.getIncome() - creditClass.getExpenses())> ( 0.30 * (creditClass.getLoanAmount()/creditClass.getHowLong())) ){
        model.addAttribute("creditYes", "Udzielono credytu");
        return "/mainCredit";
    }else{
        model.addAttribute("creditNo", "Nie udzielono credytu");
        return "/mainCredit";
    }
}


}
