import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//public class Text {
//    //返回的是字符串型的时间，输入的
//    //是String day, int x
//    public static String addDateMinut(String day, int x){
//
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 24小时制
//        //引号里面个格式也可以是 HH:mm:ss或者HH:mm等等，很随意的，不过在主函数调用时，要和输入的变
//        //量day格式一致
//        Date date = null;
//        try {
//            date = format.parse(day);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        if (date == null)
//            return "";
//        System.out.println("front:" + format.format(date)); //显示输入的日期
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(date);
//        cal.add(Calendar.MINUTE, x);// 24小时制
//        date = cal.getTime();
//        System.out.println("after:" + format.format(date));  //显示更新后的日期
//        cal = null;
//        return format.format(date);


//
//
//    }
//
//}
