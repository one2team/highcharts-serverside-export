package org.one2team.utils;
import com.google.gwt.shared.ArrayString;

@SuppressWarnings("serial")
public class JSMArrayString extends JSMArray<String> implements ArrayString {

  @Override
  public String join () {
    return join (",");
  }

  @Override
  public String join (String separator) {
    StringBuffer sb = new StringBuffer ();
    int size;
    
    if ((size = length ()) < 1)
      return sb.toString ();
      
    sb.append (getItem (0));
    for ( int i = 1; i < size; i++) {
      sb.append (separator);
      sb.append (getItem (i));
    }
    
    return sb.toString ();
  }

  @Override
  public JSMArrayString pushString (String value) {
    pushItem (value);
    return this;
  }

	@Override
	public ArrayString setString (int index, String value) {
    setItem (index, value);
    return this;
	}

  @Override
  public void setLength (int newLength) {
  }

  @Override
  public String shiftItem () {
    if (length () < 1)
      return null;
    
    return remove(0);
  }

  @Override
  public void unshiftItem (String value) {
    add (0, value);
  }

}
