package com.avloger.controller;

import com.avloger.pojo.Books;
import com.avloger.service.BookService;
import lombok.Lombok;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : avloger
 * @date : 2021/11/28 12:29
 */
@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    @RequestMapping("/allBook")
    public String list(Model model) {
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list", list);
        return "allBooks";
    }
    //跳转到增加书籍页面
    @RequestMapping("/toAddBook")
    public String toAddPaper() {
        return "addBook";
    }
    @RequestMapping("/addBook")
    public String addBook(Books books) {
        System.out.println("addBook="+books);
        bookService.addBook(books);
        return "redirect:/book/allBook";
    }
    /*跳转到修改页面*/
    @RequestMapping("/toUpdate")
    public String toUpdatePaper(int id, Model model) {
        Books books = bookService.queryBookById(id);
        model.addAttribute("Qbook",books);
        return  "updateBook";
    }
    /*修改书籍*/
    @RequestMapping("/updateBook")
    public String updateBook(Books books) {
        System.out.println("updateBook=" + books);
        bookService.updateBook(books);
        return "redirect:/book/allBook";
    }
    /*删除书籍*/
    @RequestMapping("/deleteBook/{bookid}")
    public String deleteBook(@PathVariable("bookid") int id) {
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }
    /*查询*/
    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName,Model model) {
        Books books = bookService.queryBookByName(queryBookName);


        List<Books> list = new ArrayList<Books>();
        list.add(books);
        if(books == null) {
            list = bookService.queryAllBook();
            model.addAttribute("error","未查到");
        }
        model.addAttribute("list", list);
        return "allBooks";
    }
}
