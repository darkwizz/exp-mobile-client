package com.example.artur.exp_mobile_android.model.entities.jsondeserializers;

import com.example.artur.exp_mobile_android.model.entities.ExpPerson;
import com.example.artur.exp_mobile_android.model.entities.ExpPersonStatus;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/*
{
  "paging": {
    "total_items": 4271,
    "current_page": 1,
    "total_pages": 171
  },
  "data": [
    {
      "id": 1088835,
      "email": "vladimir.korbach@gmail.com",
      "url": "https://gis.aiesec.org/v1/people/1088835",
      "first_name": "Vladimir",
      "dob": "1986-02-04",
      "full_name": "Vladimir Korbach",
      "last_name": "Korbach",
      "profile_photo_url": "https://gis-img.s3.amazonaws.com/missing_profile_v.svg",
      "home_lc": {
        "id": 1461,
        "name": "KYIV",
        "full_name": "AIESEC in KYIV",
        "url": "https://gis.aiesec.org/v1/offices/1461"
      },
      "home_mc": {
        "id": 1610,
        "name": "UKRAINE",
        "full_name": "AIESEC in UKRAINE",
        "url": "https://gis.aiesec.org/v1/offices/1610"
      },
      "status": "open",
      "interviewed": false,
      "phone": "+380634335070",
      "contacted_at": null,
      "contacted_by": null,
      "programmes": [],
      "location": "ukraine",
      "managers": [],
      "nps_score": 0,
      "cv_info": {
        "url": "https://gis-production.s3.amazonaws.com/attachments/person/1468927969_original.docx",
        "thumb": null,
        "name": "VK_CV.docx",
        "type": "application/vnd.openxmlformats-officedocument.wordprocessingml.document",
        "size": "88.1 KB",
        "tag": "cv",
        "description": null
      },
      "created_at": "2016-07-19T09:27:27Z",
      "updated_at": "2016-07-19T11:33:23Z"
    },
 */


/**
 * Created by artur on 19.07.16.
 */
public class ExpPersonDeserializer implements JsonDeserializer<ExpPerson> {
    @Override
    public ExpPerson deserialize(JsonElement json, Type typeOfT,
                                 JsonDeserializationContext context) throws JsonParseException {
        if (json == null) {
            return null;
        }
        JsonObject result = json.getAsJsonObject();
        JsonElement idElement = result.get("id");
        if (idElement == null) {
            return null;
        }
        JsonElement firstNameElement = result.get("first_name");
        JsonElement lastNameElement = result.get("last_name");
        JsonElement emailElement = result.get("email");
        JsonElement phoneElement = result.get("phone");
        JsonElement isInterviewedElement = result.get("interviewed");
        JsonElement lcElement = result.get("home_lc");
        JsonElement mcElement = result.get("home_mc");
        JsonElement statusElement = result.get("status");
        JsonElement managersElement = result.get("managers");

        ExpPerson person = new ExpPerson(idElement.getAsString());
        if (firstNameElement != null) {
            person.setFirstName(firstNameElement.getAsString());
        }
        if (lastNameElement != null) {
            person.setLastName(lastNameElement.getAsString());
        }
        if (emailElement != null) {
            person.setEmail(emailElement.getAsString());
        }
        if (phoneElement != null) {
            person.setPhone(phoneElement.getAsString());
        }
        if (isInterviewedElement != null) {
            person.setInterviewed(isInterviewedElement.getAsBoolean());
        }
        if (lcElement != null) {
            JsonElement lcName = lcElement.getAsJsonObject().get("name");
            if (lcName != null) {
                person.setLcName(lcName.getAsString());
            }
        }
        if (mcElement != null) {
            JsonElement mcName = mcElement.getAsJsonObject().get("name");
            if (mcName != null) {
                person.setLcCountryName(mcName.getAsString());
            }
        }
        if (statusElement != null) {
            ExpPersonStatus status = ExpPersonStatus.fromString(statusElement.getAsString());
            person.setStatus(status);
        }
        if (managersElement != null) {
            JsonArray managersItems = managersElement.getAsJsonArray();
            Type listPersonsType = new TypeToken<List<ExpPerson>>(){}.getType();
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(ExpPerson.class, new ExpPersonDeserializer())
                    .create();
            List<ExpPerson> managers = gson.fromJson(managersItems, listPersonsType);
            person.getManagers().addAll(managers);
        }
        return person;
    }
}
