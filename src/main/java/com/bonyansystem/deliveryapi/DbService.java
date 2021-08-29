package com.bonyansystem.deliveryapi;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Hashtable;

public class DbService {

    public void insertEntity(DeliveryEntity delivery) throws SQLException {
        Context ctx;

        Hashtable<String, String> ht = new Hashtable<>();
        //initializing the weblogic adress to connect
        ht.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
        ht.put(Context.PROVIDER_URL, "t3://localhost:7001");
        Connection conn = null;
        PreparedStatement stmt = null;

        //establishing  connection to data source
        try {
            ctx = new InitialContext(ht);
            javax.sql.DataSource ds;
            ds = (javax.sql.DataSource) ctx.lookup("jndiSerly");
            conn = ds.getConnection();

            stmt = conn.prepareStatement(
                    "insert into sp_delivery_tab(Id, daykey, delid, msisdn, " +
                    "part, opstat, status) " +
                    "values(?, ?, ?, ?, ?, ?, ?)");

            stmt.setInt(1, delivery.getId()); //Id
            stmt.setInt(2, delivery.getDaykey()); //daykey
            stmt.setInt(3,delivery.getDelid() );
            stmt.setInt(4, delivery.getMsisdn());
            stmt.setInt(5, delivery.getPart());
            stmt.setInt(6, delivery.getOpStat());
            stmt.setString(7, delivery.getStatus());

            System.out.println(delivery.getStatus());

            stmt.execute();
            stmt.close();
            conn.close();
            ctx.close();

        } catch (NamingException | SQLException ex) {
            ex.printStackTrace();
            return;
        } finally {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        }

        // using conn object to create Statements and retrieve result sets
      //  System.out.println("can't close the statement");
        //closing context
      //  System.out.println("can't close the context ,statement or connection.");
    }
}