package StringConcat;

/**
* StringConcat/ConcatenatorHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from StringConcat.idl
* Tuesday, May 30, 2023 12:31:21 AM EDT
*/

public final class ConcatenatorHolder implements org.omg.CORBA.portable.Streamable
{
  public StringConcat.Concatenator value = null;

  public ConcatenatorHolder ()
  {
  }

  public ConcatenatorHolder (StringConcat.Concatenator initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = StringConcat.ConcatenatorHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    StringConcat.ConcatenatorHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return StringConcat.ConcatenatorHelper.type ();
  }

}
