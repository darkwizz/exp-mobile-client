package com.example.artur.exp_mobile_android.model.entities.jsondeserializers;

import com.example.artur.exp_mobile_android.model.entities.ExpOpportunity;
import com.example.artur.exp_mobile_android.model.entities.ExpOpportunityStatus;
import com.example.artur.exp_mobile_android.model.entities.ExpPerson;
import com.example.artur.exp_mobile_android.model.entities.ExpProgramKind;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
{
  "paging": {
    "total_items": 1561,
    "current_page": 1,
    "total_pages": 63
  },
  "data": [
    {
      "status": "open",
      "applications_close_date": null,
      "is_favourited": false,
      "title": "Training Team",
      "url": "https://gis.aiesec.org/v2/opportunities/564297",
      "created_at": "2031-05-08T00:00:00Z",
      "views": 396,
      "updated_at": "2008-06-28T00:00:00Z",
      "current_status": "unmatched",
      "applications_count": 0,
      "cover_photo_urls": "https://gis-img.s3.amazonaws.com/missing_opportunity_cover.png",
      "location": "KYIV",
      "branch": {
        "url": "https://gis.aiesec.org/v2/organisations//branches/271528",
        "organisation_id": 271043,
        "id": 271528,
        "profile_photo_url": "https://gis-img.s3.amazonaws.com/missing_profile_s.svg",
        "name": "Summer Camp"
      },
      "duration_max": 9,
      "profile_photo_urls": {
        "medium": "https://gis-img.s3.amazonaws.com/missing_profile_t.svg",
        "original": "https://gis-img.s3.amazonaws.com/missing_profile_t.svg",
        "thumb": "https://gis-img.s3.amazonaws.com/missing_profile_t.svg"
      },
      "duration_min": 8,
      "earliest_start_date": "2008-06-28T00:00:00.000Z",
      "programmes": {
        "id": 1,
        "short_name": "GCDP"
      },
      "id": 564297,
      "latest_end_date": "2008-09-03T00:00:00.000Z"
    },...
    ]
    }
 */

/**
 * Created by artur on 19.07.16.
 */
public class ExpOpportunityDeserializer implements JsonDeserializer<ExpOpportunity> {
    @Override
    public ExpOpportunity deserialize(JsonElement json, Type typeOfT,
                                      JsonDeserializationContext context) throws JsonParseException {
        if (json == null || json.isJsonNull()) {
            return null;
        }
        JsonObject result = json.getAsJsonObject();

        JsonElement idElement = result.get("id");
        if (idElement == null || idElement.isJsonNull()) {
            return null;
        }
        JsonElement titleElement = result.get("title");
        JsonElement dateElement = result.get("earliest_start_date");
        JsonElement durationMaxElement = result.get("duration_max");
        JsonElement durationMinElement = result.get("duration_min");
        JsonElement statusElement = result.get("status");

        ExpOpportunity opportunity = new ExpOpportunity(idElement.getAsString());
        if (titleElement != null && !titleElement.isJsonNull()) {
            opportunity.setTitle(titleElement.getAsString());
        }
        if (dateElement != null && !dateElement.isJsonNull()) {
            Date date = deserializeDate(dateElement);
            opportunity.setEarliestStartDate(date);
        }
        if (durationMaxElement != null && !durationMaxElement.isJsonNull()) {
            opportunity.setDurationMaximal(durationMaxElement.getAsInt());
        }
        if (durationMinElement != null && !durationMinElement.isJsonNull()) {
            opportunity.setDurationMinimal(durationMinElement.getAsInt());
        }
        if (statusElement != null && !statusElement.isJsonNull()) {
            ExpOpportunityStatus status = ExpOpportunityStatus
                    .fromString(statusElement.getAsString());
            opportunity.setStatus(status);
        }
        JsonElement programElement = result.get("programmes");
        if (programElement != null && !programElement.isJsonNull()) {
            String programName = programElement.getAsJsonObject().get("short_name").getAsString();
            ExpProgramKind program = ExpProgramKind.fromString(programName);
            opportunity.setProgramKind(program);
        }
        JsonElement managersElement = result.get("managers");
        if (managersElement != null && !managersElement.isJsonNull()) {
            JsonArray managersItems = managersElement.getAsJsonArray();
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(ExpPerson.class, new ExpPersonDeserializer())
                    .create();
            Type type = new TypeToken<List<ExpPerson>>(){}.getType();
            List<ExpPerson> managers = gson.fromJson(managersItems, type);
            opportunity.getManagers().addAll(managers);
        }
        return opportunity;
    }

    private Date deserializeDate(JsonElement dateElement) {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.S")
                .create();
        Date date = gson.fromJson(dateElement, Date.class);
        return date;
    }
}
