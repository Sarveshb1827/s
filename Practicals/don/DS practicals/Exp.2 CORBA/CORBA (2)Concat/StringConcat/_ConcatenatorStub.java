package StringConcat;


/**
* StringConcat/_ConcatenatorStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from StringConcat.idl
* Tuesday, May 30, 2023 12:31:21 AM EDT
*/

public class _ConcatenatorStub extends org.omg.CORBA.portable.ObjectImpl implements StringConcat.Concatenator
{

  public String concatenate (String s1, String s2)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("concatenate", true);
                $out.write_string (s1);
                $out.write_string (s2);
                $in = _invoke ($out);
                String $result = $in.read_string ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return concatenate (s1, s2        );
            } finally {
                _releaseReply ($in);
            }
  } // concatenate

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:StringConcat/Concatenator:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     org.omg.CORBA.Object obj = orb.string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
   } finally {
     orb.destroy() ;
   }
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     String str = orb.object_to_string (this);
     s.writeUTF (str);
   } finally {
     orb.destroy() ;
   }
  }
} // class _ConcatenatorStub
