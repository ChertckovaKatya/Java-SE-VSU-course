import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;


public class ReflectionChecker
{

    public String showFieldsAnnotations(Object object) {
        Class clazz = object.getClass();
        Field [] fields = clazz.getDeclaredFields();
        List<String> list_annot = new LinkedList<>();
        for (Field field : fields){
            Annotation annotation = field.getAnnotation(Deprecated.class);
            if (annotation!=null){
                list_annot.add(field.getName());
            }

        }
        String name_class = clazz.getName();
        String csv = String.join(" , ", list_annot);
        String result = name_class+" : "+csv;
        return result;
    }

}
