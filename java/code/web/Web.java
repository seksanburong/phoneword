package web;
import java.util.ArrayList;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class Web{
    @RequestMapping("/show")
    String showHome(Model model){
        String[] data={"Latte","Mocha","Espresso"};
        model.addAttribute("brand","iCoffee");
        model.addAttribute("products",data);
        return "home";
    }
    @RequestMapping({"/register","/join"})
    String showRegisterPage(Model model,String city,String code){
        model.addAttribute("result",false);
        try{
            int k=Integer.valueOf(code);
            if(k%2==0){
                model.addAttribute("result",true);
            }
        }catch(Exception e){}
        return "register"; //"register,html" important suffix 
    }
    @RequestMapping("/shownumber")
    String show(Model model,String number){
        ArrayList a=new ArrayList();
        String type="";
        try{
            int value=Integer.valueOf(number);
            if(value%2==0) {type="Even";}
            else {type="Odd";}
            for(int i=1;i<=value;i++){
                if(value%i==0){
                    a.add(i);
                }
            }
        }catch(Exception e){}
        model.addAttribute("type",type);
        model.addAttribute("result",a);
        return "sample";
    }
    @RequestMapping("/api") @ResponseBody  //use create webservice add condition @ResponseBody
    ArrayList listStaff(){
        ArrayList a=new ArrayList();
        a.add("Bill Gates");
        return a;
    }
}
