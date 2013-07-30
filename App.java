import java.io.*;
import javax.script.*;

public class App
{
    public static void main(String[] args)
    {
        try
        {
            ScriptEngine engine = 
                new ScriptEngineManager().getEngineByName("javascript");
            for (String arg : args)
            {
                FileReader fr = new FileReader(arg);
                engine.eval(fr);
            }
        }
        catch(IOException ioEx)
        {
            ioEx.printStackTrace();
        }
        catch(ScriptException scrEx)
        {
            scrEx.printStackTrace();
        }
    }
}