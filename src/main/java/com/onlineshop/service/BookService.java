package com.onlineshop.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.onlineshop.dao.BookDao;
import com.onlineshop.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 图书相关服务
 *
 * @author kaizhang
 * @create 2018-04-28 0:51
 **/
@Service
public class BookService {
    @Autowired
    BookDao bookDao;

    /**
     * 根据分类查找图书
     *
     * @param classifyId
     * @return
     */
    public PageInfo queryBookByClassifyID(String classifyId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize, true);
        List<Book> list = bookDao.queryBookByClassifyID(classifyId);
        return new PageInfo<Book>(list);
    }

    /**
     * 返回指定页所有图书信息
     *
     * @return
     */
    public PageInfo<Book> queryAllBook(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize, true);
        List<Book> books = bookDao.queryAllBook();
        return new PageInfo<Book>(books);
    }

    /**
     * 使用图书id查询图书
     *
     * @param bookId
     * @return
     */
    public Book selectByPrimaryKey(Integer bookId) {
        return bookDao.selectByPrimaryKey(bookId);
    }

    /**
     * 按作者查询图书
     *
     * @param author
     * @return
     */
    public PageInfo queryBookByAuthor(String author, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize, true);
        List<Book> list = bookDao.queryBookByAuthor(author);
        return new PageInfo<Book>(list);
    }

    /**
     * 按出版社查询图书
     *
     * @param publisher
     * @return
     */
    public PageInfo queryBookByPress(String publisher, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize, true);
        List<Book> list = bookDao.queryBookByPress(publisher);
        return new PageInfo<Book>(list);
    }

    /**
     * 按书名模糊查询
     *
     * @param bookName
     * @return
     */
    public PageInfo queryBookByLikeName(String bookName, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize, true);
        List<Book> list = bookDao.queryBookByLikeName(bookName);
        return new PageInfo<Book>(list);
    }

    /**
     * 多条件组合查询
     *
     * @param bookName
     * @param Author
     * @param ISBN
     * @param publisher
     * @return
     */
    public PageInfo queryBookByCombine(String bookName, String Author, String ISBN, String publisher, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize, true);
        List<Book> list = bookDao.queryBookByCombine(bookName, Author, ISBN, publisher);
        return new PageInfo<Book>(list);
    }
}
