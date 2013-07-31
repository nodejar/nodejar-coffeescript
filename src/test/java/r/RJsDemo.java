package r;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

public class RJsDemo {
	  
    @Test
    public void simpleRhinoTest() throws FileNotFoundException, IOException {
	    Context cx = Context.enter();
	
	    final JsRuntimeSupport browserSupport = new JsRuntimeSupport();
	
	    final ScriptableObject sharedScope = cx.initStandardObjects(browserSupport, true);
	
	    String[] names = { "print", "load" };
	    sharedScope.defineFunctionProperties(names, sharedScope.getClass(), ScriptableObject.DONTENUM);
	
	    Scriptable argsObj = cx.newArray(sharedScope, new Object[] {});
	    sharedScope.defineProperty("arguments", argsObj, ScriptableObject.DONTENUM);
	 
	    cx.evaluateReader(sharedScope, new FileReader("./r.js"), "require", 1, null);
	    cx.evaluateReader(sharedScope, new FileReader("./loader.js"), "loader", 1, null);
	
	    Context.exit();
  }

}
