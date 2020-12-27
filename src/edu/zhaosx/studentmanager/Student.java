package edu.zhaosx.studentmanager;

public class Student {
    public String id,name,school;
    public Student(){

    }

    public Student(String id,String name,String school){
        this.id = id;
        this.name = name;
        this.school = school;
    }

    //select id,name,school from ? where id = ? and name = ? and school = ?
    public String getSearchSql(){
           String sql = "select ";
           if(!this.id.equals(""))
               sql += "id,";
           if(!this.name.equals(""))
               sql += "name,";
           if(!this.school.equals(""))
               sql += "school,";
           if(sql.equals("select "))
               return "select * from ?";
           sql = sql.substring(0, sql.length() -1);
           sql += " for ? where";
           if(!this.id.equals(""))
               sql += " id = "+this.id+" and";
            if(!this.name.equals(""))
                sql += "name = "+this.name+" and";
            if(!this.school.equals(""))
                sql += "shcool = "+this.school+" and";
            sql = sql.substring(0, sql.length() -4);
        return sql;
    }

}
