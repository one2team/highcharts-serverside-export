package org.one2team.highcharts.server.dynamic;

import java.util.HashMap;
import java.util.Map;

import org.one2team.highcharts.server.JSMBaseObject;
import org.one2team.highcharts.shared.dynamic.Element;


public class JSMElement extends JSMBaseObject implements Element {
  
  public JSMElement () {
    map = new HashMap<String, String> ();
  }

  @Override
  public void attr (String property, String value) {
    map.put (property, value);
  }
  
  public String getAttr (String property) {
    return map.get (property);
    
  }
  
  private Map<String, String> map;

}
