package com.flipkart.controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.flipkart.model.*;
import com.flipkart.business.FlipfitGymCentreService;
import com.flipkart.business.FlipfitGymOwnerService;
import com.flipkart.business.FlipfitGymSlotService;
import com.flipkart.business.FlipfitGymSlotServiceInterface;
import com.flipkart.business.*;
import com.flipkart.utils.addSlotDTO;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Path("/gym-owner")
@Produces(MediaType.APPLICATION_JSON)
public class FlipfitGymOwnerController {

    FlipfitGymOwnerServiceInterface gymOwnerService = new FlipfitGymOwnerService();
    FlipfitGymCentreServiceInterface gymCentreService  = new FlipfitGymCentreService();

    FlipfitGymSlotServiceInterface slotService = new FlipfitGymSlotService();


    @GET
    @Path("view-all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCentresByOwnerId() {
        return Response.ok(gymOwnerService.viewAllGymOwners()).build();
    }

    @Path("/gym-centres")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCentresByOwnerId(@QueryParam("gymOwnerId") String gymOwnerId) {
        FlipfitGymCentreService gymCentreService = new FlipfitGymCentreService();
        return Response.ok(gymCentreService.getAllCentresByOwmerId(gymOwnerId)).build();
    }

    @GET
    @Path("/login")
    public Response GymOwnerLogin(@QueryParam("userName") String userName, @QueryParam("password") String password) {
        FlipfitGymOwner gymOwner = gymOwnerService.loginGymOwner(userName, password);
        if(gymOwner==null)
            return Response.notModified().build();
        return Response.ok(gymOwner).build();
    }
    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response GymOwnerRegister(FlipfitGymOwner gymOwner) {
        FlipfitGymOwner registerdGymOwner =  gymOwnerService.registerGymOwner(gymOwner);
        if(registerdGymOwner==null)
            return Response.notModified().build();
        return Response.ok(registerdGymOwner).build();
    }
    @POST
    @Path("/add-centre")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addGymCentre(FlipfitGymCentre gymCentre) {
        FlipfitGymCentre newGymCentre = gymCentreService.addCenter(gymCentre);
        if(newGymCentre==null)
            return Response.notModified().build();
        return Response.ok(newGymCentre).build();
    }

    @Path("/get-approval-owner")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response requestGymOwnerApproval(@QueryParam("gymOwnerId") String gymOwnerId) {
        gymOwnerService.requestGymOwnerApproval(gymOwnerId);
        return Response.ok("Sent approval request to Admin").build();
    }

    @Path("/get-approval-centre")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response requestGymCentreApproval(@QueryParam("gymCentreId") String gymCentreId) {
        gymCentreService.requestGymCentreApproval(gymCentreId);
        return Response.ok("Sent approval request to Admin").build();
    }
    @Path("/get-gym-centre")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response requestGymCentreById(@QueryParam("gymCentreId") String gymCentreId) {

        return Response.ok(gymCentreService.getGymCentreById(gymCentreId)).build();
    }


    @Path("/get-available-slots")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAvailableSlots(@QueryParam("centreId") String centreId,@QueryParam("Date") String strdate) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        java.util.Date date;
        Date sqlDate = null;
        try {
            date = sdf.parse(strdate);
            sqlDate = new Date(date.getTime());
        } catch (ParseException e) {
            System.out.println("\n\n\n\n\n\n UNABLE TO PARSE");
        }
        return Response.ok(gymCentreService.getAvailableSlotsByCentreAndDate(centreId,sqlDate)).build();
    }


    @Path("/get-centres-by-city")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCentreByCity(@QueryParam("cityName") String cityName) {

        return Response.ok(gymCentreService.getCentresByCity("blore")).build();
    }

    @Path("/add-slots")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addSlotsToGym(List<addSlotDTO> slotList){
        try {
            String centreID = slotList.get(0).getCentreID();
            slotService.addSlotListForGym(centreID, slotList);
        }catch (IllegalArgumentException exp){
            System.out.println("illegal arg");
            return Response.notModified().build();
        }
        return Response.ok("Added Slots").build();
    }
}
