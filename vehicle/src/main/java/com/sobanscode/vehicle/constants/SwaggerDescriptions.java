package com.sobanscode.vehicle.constants;

public interface SwaggerDescriptions {
    String DESCRIPTION1 = "The endpoint that registers the vehicle. Vehicles must be registered as belonging to a group. Only company admins can register vehicles. CompanyId is not given in the vehicle request. The company ID belonging to the admin who registered the vehicle is automatically assigned to the vehicle.";
    String DESCRIPTION2 = "The endpoint that authorizes the user to the tool. If the user already has authority over the group in which the vehicle is located, a conflict occurs.";
    String DESCRIPTION3 = "An endpoint that returns a list of vehicles to which the user is authorized directly, rather than through groups.";
    String DESCRIPTION4 = "The endpoint returned in the list structure of the vehicles to which the user given by userId is directly authorized. Only company admins can use it.";
    String DESCRIPTION5 = "Endpoint that returns a list of all vehicles under Company. Only company admins can use it.";
}
