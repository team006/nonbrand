package com.nonbrand.nonbrand.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nonbrand.nonbrand.entity.product.*;
import com.nonbrand.nonbrand.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

@Controller
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ColorRepository colorRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private TypeRepository typeRepository;
    @Autowired
    private ModelRepository modelRepository;
    @Autowired
    private SizeRepository sizeRepository;

    @GetMapping("/")
    public String AllItems(ModelMap model){
        List<Item> allItems = itemRepository.findAll();
        model.addAttribute("AllItems", allItems);
        return "index";
    }

    @GetMapping("/selectType")
    public String selectTypePage(ModelMap model) {
        List<Type> typeObject = typeRepository.findAll();
        model.addAttribute("typeObject", typeObject);
        return "selectType";
    }

    @GetMapping("/addItem")
    public String addItemPage() {
        return "addItem";
    }

    @GetMapping("/addItem/{typeId}")
    public String getItem(ModelMap model,
                          @PathVariable Long typeId,
                          HttpServletRequest request) {
        Type type = typeRepository.findTypeById(typeId);
        List<Color> allColor = colorRepository.findAll();

        model.addAttribute("typeObj", type);
        model.addAttribute("allColor",allColor);
//        System.out.println(typeId);
//        request.getSession(true).setAttribute("typeObj",type);
        return "addItem";
    }

    @GetMapping("/addItem/{typeId}/added")
    public String addItemToDB(ModelMap model,@PathVariable Long typeId,
                          HttpServletRequest request) {
        String modelString = request.getParameter("model");
        String sizeString = request.getParameter("size");
        Size size = sizeRepository.findByName(sizeString);
        String mainColor = request.getParameter("mainColor");
        Type type = typeRepository.findTypeById(typeId);
        String[] categoryList = new String[type.getCategoryCount()];
        String[] colorList = new String[type.getCategoryCount()];
        String[] categoryNameList = new String[type.getCategoryCount()];
        String[] colorNameList = new String[type.getCategoryCount()];
        List<Color> allColor = colorRepository.findAll();

        for(int i =0;i<type.getCategoryCount();i++){
            String catTemp = request.getParameter("category"+i);
            Category category = categoryRepository.findByName(catTemp);
                categoryList[i] = category.getCode();
        }

        for(int j =0;j<type.getCategoryCount();j++){
            String colorTemp = request.getParameter("color"+j);
            Color color = colorRepository.findByName(colorTemp);
                colorList[j] = color.getCode();
        }

        for(int i =0;i<type.getCategoryCount();i++){
            String catTemp = request.getParameter("category"+i);
            Category category = categoryRepository.findByName(catTemp);
            categoryNameList[i] = category.getName();
        }

        for(int j =0;j<type.getCategoryCount();j++){
            String colorTemp = request.getParameter("color"+j);
            Color color = colorRepository.findByName(colorTemp);
            colorNameList[j] = color.getName();
        }
        Model modelForCode = modelRepository.findByName(modelString);
        Color mainColorForCode = colorRepository.findByName(mainColor);
        String s="";
        String sName="";
        String codeTemp2 = type.getCode()+"-"+modelForCode.getCode()+"-สี"+mainColorForCode.getCode();
        String itemName = type.getName()+"-"+modelForCode.getName()+"-สี"+mainColorForCode.getName();
        for(int i =0;i<type.getCategoryCount();i++){
            if(categoryList[i].equals("null") == false){
                s=s.concat("-");
                s= s.concat(categoryList[i]);
            }
            if(colorList[i].equals("null")==false){
                s=s.concat("-");
                s= s.concat(colorList[i]);
            }
        }

        for(int i =0;i<type.getCategoryCount();i++){
            if(categoryList[i].equals("null") == false){
                sName=sName.concat("-");
                sName= sName.concat(categoryNameList[i]);
            }
            if(colorList[i].equals("null")==false){
                sName=sName.concat("-สี");
                sName= sName.concat(colorNameList[i]);
            }
        }
        String codeReal = codeTemp2 + s+"-"+size.getCode();
        String nameReal = itemName + sName+"-"+size.getName();

        System.out.println("code: "+codeReal);
        System.out.println("name: "+nameReal);

//        type-model-mainCo-cat1-col1-cat2-col2-size

        String balanceTemp = request.getParameter("balance");
        int balance = Integer.parseInt(balanceTemp);

        Item item = new Item();

        item.setBalance(balance);
        item.setCode(codeReal);
        item.setName(nameReal);
        item.setType(type);
        itemRepository.save(item);

        model.addAttribute("typeObj", type);
        model.addAttribute("allColor",allColor);
        return "addItem";
    }




}