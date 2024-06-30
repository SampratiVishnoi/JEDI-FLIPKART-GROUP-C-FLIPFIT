package com.flipkart.controller;

import com.codahale.metrics.annotation.Timed;
import com.flipkart.model.FlipfitGymAdmin;
import com.flipkart.model.FlipfitApprovalRequest;
import com.flipkart.model.FlipfitGymCentre;
import com.flipkart.model.FlipfitGymOwner;
import com.flipkart.business.FlipfitGymAdminService;
import com.flipkart.business.FlipfitGymOwnerService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/admin")
@Produces(MediaType.APPLICATION_JSON)
public class FlipfitGymAdminController {

    private static FlipfitGymAdminService adminService = new FlipfitGymAdminService();
    private static FlipfitGymOwnerService gymOwnerService = new FlipfitGymOwnerService();

    public FlipfitGymAdmin isUserValid(String userName, String password) {
        FlipfitGymAdmin admin = new FlipfitGymAdmin();
        if (userName.equals(admin.getUserName()) && password.equals(admin.getPassword())) {
            return admin;
        }
        return null;
    }


    @GET
    @Path("/login")
    @Timed
    public Response customerLogin(@QueryParam("userName") String userName, @QueryParam("password") String password) {
        FlipfitGymAdmin admin = null;
        try{
            admin = isUserValid("admin", "Admin@123");
            System.out.println("Login Successful");
            return Response.ok(admin).build();
        }catch (Exception exception){
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
        }
    }

    @GET
    @Path("/gym-owner/pending-list")
    @Timed
    public Response viewPendingGymOwners() {
        try{
            List<FlipfitGymOwner> gymOwnerList = adminService.viewPendingGymOwners();
            return Response.ok(gymOwnerList).build();
        } catch (Exception e){
            return Response.status(Response.Status.UNAUTHORIZED).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/gym-owner/all")
    @Timed
    public Response viewGymOwners(){
        try{
            List<FlipfitGymOwner> gymOwnerList = gymOwnerService.viewAllGymOwners();
            return Response.ok(gymOwnerList).build();
        } catch (Exception e){
            return Response.status(Response.Status.UNAUTHORIZED).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/gym-centre/pending-list")
    @Timed
    public Response viewPendingGymCentres(){
        try{
            List<FlipfitGymCentre> gymCentreList = adminService.viewPendingGymCentres();
            return Response.ok(gymCentreList).build();
        } catch (Exception e){
            return Response.status(Response.Status.UNAUTHORIZED).entity(e.getMessage()).build();
        }
    }

    @POST
    @Path("/gym-owner/handle")
    @Timed
    @Consumes(MediaType.APPLICATION_JSON)
    public Response handleGymOwner(FlipfitApprovalRequest approvalRequest){
        try{
            adminService.approveGymOwner(approvalRequest.getId(),approvalRequest.getChoice());
            return Response.ok("Request Handled").build();
        } catch (Exception e){
            return Response.status(400).entity("Invalid Gym Owner details").build();
        }

    }

    @POST
    @Path("/gym-centre/handle")
    @Timed
    @Consumes(MediaType.APPLICATION_JSON)
    public Response handleGymCentre(FlipfitApprovalRequest approvalRequest){
        try{
            adminService.approveGymCenter(approvalRequest.getId(),approvalRequest.getChoice());
            return Response.ok("Request Handled").build();
        } catch (Exception e){
            return Response.status(400).entity("Invalid Gym Centre details").build();
        }

    }
}