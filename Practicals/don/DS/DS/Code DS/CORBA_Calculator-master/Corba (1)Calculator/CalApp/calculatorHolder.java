package CalApp;

/**
* CalApp/calculatorHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from calculator.idl
* Monday, May 29, 2023 1:17:43 PM EDT
*/

public final class calculatorHolder implements org.omg.CORBA.portable.Streamable
{
  public CalApp.calculator value = null;

  public calculatorHolder ()
  {
  }

  public calculatorHolder (CalApp.calculator initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = CalApp.calculatorHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    CalApp.calculatorHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return CalApp.calculatorHelper.type ();
  }

}