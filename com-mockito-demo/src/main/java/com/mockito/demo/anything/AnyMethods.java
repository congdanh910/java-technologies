package com.mockito.demo.anything;

import com.mockito.demo.exception.DemoException;
import com.mockito.demo.model.Staff;
import org.apache.commons.lang.StringUtils;

import java.util.Calendar;

/**
 * Created by CongDanh on 8/18/15.
 */
public class AnyMethods {
    private static final String DEMO_MESSAGE_EXCEPTION = "This exception was expected to check AnyMethods!!!";

    public String hello(String name) {
        return "Hello : " + name;
    }

    public String getFirstName(String name) throws DemoException {
        if (StringUtils.isBlank(name)) {
            throw new DemoException(DEMO_MESSAGE_EXCEPTION);
        }
        String[] split = StringUtils.split(name);
        if (split != null && split.length > 0) {
            return split[0];
        }
        return StringUtils.EMPTY;
    }

    public int getAge(Staff staff) throws DemoException {
        if (staff == null || staff.getBirthday() == null) {
            throw new DemoException(DEMO_MESSAGE_EXCEPTION);
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(staff.getBirthday());
        return calendar.get(Calendar.YEAR);
    }
}
