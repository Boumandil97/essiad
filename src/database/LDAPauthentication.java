package database;
import project.javafx;
import session.UserRole;

import java.util.Hashtable;
import javax.net.ssl.*;



import com.mysql.cj.jdbc.ha.LoadBalancedConnection;

import com.unboundid.ldap.sdk.LDAPConnection;
import com.unboundid.ldap.sdk.migrate.ldapjdk.LDAPDN;

import java.util.Properties;
import java.util.Enumeration;
import javax.naming.ldap.*;
import javax.naming.Context;
import javax.naming.NameAlreadyBoundException;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.spi.LdapDnsProvider;
import javax.naming.ldap.spi.LdapDnsProviderResult;
import java.lang.Object;
import java.net.PasswordAuthentication;
import java.util.logging.*;


public class LDAPauthentication {
	static DirContext connection;
	public int authent(String uid,String pwd,String ou) {
		Properties env= new Properties();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL,"ldap://localhost:10389");
		env.put(Context.SECURITY_AUTHENTICATION,"simple");
		env.put(Context.SECURITY_PRINCIPAL, "uid="+uid+",ou="+ou+",o=BESSIAD,dc=example,dc=com");
		env.put(Context.SECURITY_CREDENTIALS, pwd);
		try { 
		connection=new InitialDirContext(env);
			System.out.println("connection succeded:  "+connection);
			UserRole session=new UserRole();
			session.setUserData(uid, ou);
			return 1;
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			System.out.print("connection failed: wrong username or password "); 
			return 0;
		}
		
		
	}
	public void getAllUsers(String uid,String cn) throws NamingException {
		
		String searchFilter = "(objectClass=inetOrgPerson)";
		String[]  reqAtt= {cn,uid};
		SearchControls controls= new SearchControls();
		controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
        controls.setReturningAttributes(reqAtt);  
        NamingEnumeration users= connection.search("ou=administrator,o=BESSIAD", searchFilter,controls);
        SearchResult results=null;
        while(users.hasMore()) {
        	results = (SearchResult) users.next();
        	Attributes attr=results.getAttributes();
        	System.out.println(attr.get(cn) +" " +attr.get(uid));
        }
        
	}
	//
	/*Attributes attributes =new BasicAttributes();
	Attribute attribute = new BasicAttribute("objectClass");
	attribute.add("inetOrgPerson");
	attributes.put(attribute);
	attributes.put("uid",uid);
	attributes.put("userpassword",pwd);
	attributes.put("mail",mail);
	attributes.put("cn",cn);
	attributes.put("sn",sn);
	
	
	
		try {
			connection.createSubcontext("ou="+ou+",o=SSIAD",attributes);
		}
		catch(NameAlreadyBoundException e){
			System.out.println("utilisateur exist deja");
		}
		catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}*/
	
	
	
	public void addUser(String uid,String pwd,String prenom,String nom,String mail,String ou) {
	
		
		try
		  {
			  Hashtable<String, String> ldapEnv = new Hashtable<>();
			  ldapEnv.put( Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
			  ldapEnv.put(Context.PROVIDER_URL, "ldap://localhost:10389");
			  ldapEnv.put(Context.SECURITY_AUTHENTICATION, "simple");
			  ldapEnv.put(Context.SECURITY_PRINCIPAL , "uid=admin,ou=system");
			  ldapEnv.put(Context.SECURITY_CREDENTIALS, "secret");
			  DirContext context = new InitialDirContext(ldapEnv);
			  
			  Attributes attributes =new BasicAttributes();
			  Attribute attribute =new BasicAttribute("objectClass");
			  attribute.add("inetOrgPerson");
			  attributes.put(attribute);
			  Attribute sn =new BasicAttribute("sn");
			  sn.add(nom);
			  Attribute cn =new BasicAttribute("cn");
			  cn.add(prenom);
			  
			  attributes.put(sn);
			  attributes.put(cn);
			 String ctx="uid="+uid+",ou="+ou+",o=BESSIAD";
				attributes.put("userpassword",pwd);
				attributes.put("mail",mail);
			 context.createSubcontext(ctx,attributes);
			  
			  System.out.println(" success");
		 }
		catch(NameAlreadyBoundException e){
			System.out.println("utilisateur exist deja");
		}
		catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}  catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		
		
			
	}
	public void deleteUser(String uid,String ou)
	{
		try {
			connection.destroySubcontext("uid="+uid+",ou="+ou+",o=BESSIAD");
			System.out.println("user deleted");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void searchUsers(String uid) throws NamingException {
		
		String searchFilter = "(uid="+uid+")";
		String[]  reqAtt= {"uid"};
		SearchControls controls= new SearchControls();
		controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
        controls.setReturningAttributes(reqAtt);  
        NamingEnumeration users= connection.search("ou=cadreinfirmier,o=BESSIAD", searchFilter,controls);
        SearchResult results=null;
        while(users.hasMore()) {
        	results = (SearchResult) users.next();
        	Attributes attr=results.getAttributes();
        	System.out.println(attr.get("uid"));
        }
      
	}
	public void closeauthent() {
		
		try {
			
			connection.close();
			System.out.println("session closed");
			UserRole session=new UserRole();
			session.setUserData(" ", " ");
			}
			catch (NamingException e) {
			System.out.println("operation failed");
			}
	
		
		
	}

	public static void main(String[] args) throws NamingException {
		

		//LDAPauthentication authentification=new LDAPauthentication();
		//authentification.authent("yboumandil","yuriboyka123");
		//authentification.getAllUsers("cn","userpassword");
		//authentification.addUser("hamza1","hamza123", "daanoun", "hamza", "hamzada1@gmail.com");
		//authentification.addUser("youssef2332", "yuriboyka1233", "youssefe", "boumahdie", "youssef-eee@gmail.com", "cadreinfirmier");
		//authentification.closeauthent();
		//authentification.deleteUser("ahmed123","administrator");
		//authentification.hashCode();
		//String mdp="yuriboyka123";
		//authentification.searchUsers("yboumandil");
		
		
}
}

