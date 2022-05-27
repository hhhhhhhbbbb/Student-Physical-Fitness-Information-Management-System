package com.dao;

import com.domain.Student;

import java.util.List;

public interface IStudentDAO {
    public abstract Student create(Student stu) throws Exception;//添加记录
    public abstract int remove(Student stu) throws Exception;//删除记录信息
    public abstract Student find(Student stu) throws  Exception;//查找记录信息
    public abstract List<Student> findAll() throws  Exception;//罗列所有所有信息
    public abstract void update(Student stu) throws Exception;//修改记录信息
}
