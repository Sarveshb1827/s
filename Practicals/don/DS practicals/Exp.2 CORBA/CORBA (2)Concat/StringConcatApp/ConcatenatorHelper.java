package StringConcat;


/**
* StringConcat/ConcatenatorHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from StringConcat.idl
* Monday, May 29, 2023 2:10:55 PM EDT
*/

abstract public class ConcatenatorHelper
{
  private static String  _id = "IDL:StringConcat/Concatenator:1.0";

  public static void insert (org.omg.CORBA.Any a, StringConcat.Concatenator that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static StringConcat.Concatenator extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (StringConcat.ConcatenatorHelper.id (), "Concatenator");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static StringConcat.Concatenator read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_ConcatenatorStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, StringConcat.Concatenator value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static StringConcat.Concatenator narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof StringConcat.Concatenator)
      return (StringConcat.Concatenator)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      StringConcat._ConcatenatorStub stub = new StringConcat._ConcatenatorStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static StringConcat.Concatenator unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof StringConcat.Concatenator)
      return (StringConcat.Concatenator)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      StringConcat._ConcatenatorStub stub = new StringConcat._ConcatenatorStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}