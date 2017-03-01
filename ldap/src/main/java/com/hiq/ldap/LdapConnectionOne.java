package com.hiq.ldap;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

public class LdapConnectionOne {

	public static void main(String[] args) {
		
		final String ldapAdServer = "ldap://10.0.0.4:389";
        final String ldapSearchBase = "dc=abacus";
        final String ldapSearchBasegroup = "cn=admin,ou=groups,dc=abacus";
        final String ldapSearchBaseusers = "ou=groups,dc=abacus";
        final String ldapUsername = "cn=admin,dc=abacus";
        final String ldapPassword = "hcTkuy4PCG86";
        
		Hashtable env = new Hashtable(11);
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL,ldapAdServer );
//		env.put(Context.SECURITY_AUTHENTICATION, "none");
		env.put(Context.SECURITY_PRINCIPAL, ldapUsername);
		env.put(Context.SECURITY_CREDENTIALS, ldapPassword);
		
		try {
	        LdapContext ctx = new InitialLdapContext(env, null);
	        ctx.setRequestControls(null);
	        System.out.println(ctx.getEnvironment());
	        NamingEnumeration<?> namingEnum = ctx.search(ldapSearchBase, "(objectclass=simpleSecurityObject)", getSimpleSearchControls());
	        NamingEnumeration<?> namingEnumone = ctx.search(ldapSearchBase, "(objectclass=posixAccount)", getSimpleSearchControls());
	        NamingEnumeration<?> namingEnumgroup = ctx.search(ldapSearchBasegroup, "(objectclass=posixGroup)", getSimpleSearchControls());
	        NamingEnumeration<?> namingEnumuser = ctx.search(ldapSearchBaseusers, "(objectclass=posixAccount)", getSimpleSearchControls());
	        while (namingEnum.hasMore ()) {
	            SearchResult result = (SearchResult) namingEnum.next ();    
	            Attributes attrs = result.getAttributes ();
	            System.out.println(attrs.get("cn"));
	        } 
	        namingEnum.close();
	        while (namingEnumone.hasMore ()) {
	            SearchResult result = (SearchResult) namingEnumone.next ();    
	            Attributes attrs = result.getAttributes ();
	            System.out.println(attrs.get("cn"));
	            System.out.println(attrs.get("gidNumber"));
	            System.out.println(attrs.get("homeDirectory"));
	            System.out.println(attrs.get("objectClass"));
	            System.out.println(attrs.get("sn"));
	            System.out.println(attrs.get("uidNumber"));
	        }
	        namingEnumone.close();
	        while (namingEnumgroup.hasMore ()) {
	        	 SearchResult result = (SearchResult) namingEnumgroup.next ();    
		         Attributes attrs = result.getAttributes ();
		         System.out.println(attrs.get("cn"));
		         System.out.println(attrs.get("gidNumber"));
		         System.out.println(attrs.get("objectClass"));
	        }
	        namingEnumone.close();
	        while (namingEnumuser.hasMore ()) {
	            SearchResult result = (SearchResult) namingEnumuser.next ();    
	            Attributes attrs = result.getAttributes ();
	            System.out.println(attrs.get("cn"));
	            System.out.println(attrs.get("gidNumber"));
	            System.out.println(attrs.get("homeDirectory"));
	            System.out.println(attrs.get("objectClass"));
	            System.out.println(attrs.get("sn"));
	            System.out.println(attrs.get("uidNumber"));
	        }
	        namingEnumuser.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	private static SearchControls getSimpleSearchControls() {
	    SearchControls searchControls = new SearchControls();
	    searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);
	    searchControls.setTimeLimit(30000);
	    //String[] attrIDs = {"objectGUID"};
	    //searchControls.setReturningAttributes(attrIDs);
	    return searchControls;
	}
}
