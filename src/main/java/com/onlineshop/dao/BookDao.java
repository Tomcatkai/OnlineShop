package com.onlineshop.dao;

import com.onlineshop.entity.Book;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDao {
    int deleteByPrimaryKey(Integer bookId);

    int insert(Book record);

    int insertSelective(Book record);

    /**
     * 使用图书id查找图书
     * @param bookId 图书id
     * @return book对象
     */
    Book selectByPrimaryKey(Integer bookId);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);

    /**
     * 按分类查找图书
     * @param classifyID 分类id
     * @return 图书list
     */
    List<Book> queryBookByClassifyID(String classifyID);

    /**
     * 查询所有图书信息
     * @return 图书list
     */
    List<Book> queryAllBook();


    /**
     * 按作者查询图书
     * @param author 作者
     * @return 图书list
     */
    List<Book> queryBookByAuthor(String author);


    /**
     * 按出版社查询图书
     * @param publisher 出版社
     * @return 图书list
     */
    List<Book> queryBookByPress(String publisher);


    /**
     * 按书名模糊查询
     * @param bookName 图书名
     * @return 图书list
     */
    List<Book> queryBookByLikeName(String bookName);


    /**
     * 多条件组合查询
     * @param bookName 图书名
     * @param Author 图书作者
     * @param ISBN 图书isbn号
     * @param publisher 出版社
     * @return 图书list
     */
    List<Book> queryBookByCombine(@Param("bookName")String bookName,@Param("Author")String Author, @Param("ISBN")String ISBN, @Param("publisher")String publisher);
}