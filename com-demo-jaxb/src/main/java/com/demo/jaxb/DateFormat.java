package com.demo.jaxb;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by danh.ho on 21/07/2015.
 */
public class DateFormat extends XmlAdapter<String, Date> {
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


    @Override
    public Date unmarshal(String createDate) throws Exception {
        if (createDate != null) {
            return sdf.parse(createDate);
        }
        return null;
    }

    @Override
    public String marshal(Date createDate) throws Exception {
        if (createDate != null) {
            return sdf.format(createDate).toString();
        }
        return null;
    }
}
