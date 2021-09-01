package com.bonyansystem.deliveryapi;

import javax.ws.rs.*;

//defining the path of request and entry variables
@Path("/delivery")
public class Delivery {
	//{delivery}?id={id}&daykey={daykey}&delid={deliveryId}&msisdn={msisdn}&part={part}&opstat={opStat}&stat={stat}
	//http://localhost:7001/DeliveryAPI-1.0-SNAPSHOT/api/delivery?id=1&daykey=1&delid=1&msisdn=1&part=1&opstat=1&stat=fine

	//delivery?id=12345&daykey=14000526&delid=1325&msisdn=0936979&part=1&opstat=12&stat=done
	@GET
	@Produces("text/plain")
	//get entry variables and passing to Database as an entity
	public String insert(@QueryParam("id")  int id, @QueryParam("daykey") int daykey,
						 @QueryParam("delid") int deliveryId,
						 @QueryParam("msisdn") int msisdn, @QueryParam("part") int part,
						 @QueryParam("opstat") int op, @QueryParam("stat") String stat) {
		try {
			DeliveryEntity delivery = new DeliveryEntity(id, daykey, deliveryId, msisdn, part, op, stat);
			DbService service = new DbService();
			service.insertEntity(delivery);
			return "DONE";
		}
		catch (Exception e){
			return  "Insertion Failed";
		}
	}
}
