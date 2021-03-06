
package com.telerivet;
        
import java.io.IOException;
import org.json.JSONObject;
import org.json.JSONArray;
        
/**
    Represents a phone or gateway that you use to send/receive messages via Telerivet.
    
    Fields:
    
      - id (string, max 34 characters)
          * ID of the phone
          * Read-only
      
      - name
          * Name of the phone
          * Updatable via API
      
      - phone_number (string)
          * Phone number of the phone
          * Updatable via API
      
      - phone_type
          * Type of this phone/gateway (e.g. android, twilio, nexmo, etc)
          * Read-only
      
      - country
          * 2-letter country code (ISO 3166-1 alpha-2) where phone is from
          * Read-only
      
      - send_paused (bool)
          * True if sending messages is currently paused, false if the phone can currently send
              messages
          * Updatable via API
      
      - time_created (UNIX timestamp)
          * Time the phone was created in Telerivet
          * Read-only
      
      - last_active_time (UNIX timestamp)
          * Approximate time this phone last connected to Telerivet
          * Read-only
      
      - vars (JSONObject)
          * Custom variables stored for this phone
          * Updatable via API
      
      - project_id
          * ID of the project this phone belongs to
          * Read-only
      
      - battery (int)
          * Current battery level, on a scale from 0 to 100, as of the last time the phone
              connected to Telerivet (only present for Android phones)
          * Read-only
      
      - charging (bool)
          * True if the phone is currently charging, false if it is running on battery, as of
              the last time it connected to Telerivet (only present for Android phones)
          * Read-only
      
      - app_version
          * Currently installed version of Telerivet Android app (only present for Android
              phones)
          * Read-only
      
      - android_sdk (int)
          * Android SDK level, indicating the approximate version of the Android OS installed on
              this phone; see
              <http://developer.android.com/guide/topics/manifest/uses-sdk-element.html#ApiLevels>
              (only present for Android phones)
          * Read-only
      
      - mccmnc
          * Code indicating the Android phone's current country (MCC) and mobile network
              operator (MNC); see <http://en.wikipedia.org/wiki/Mobile_country_code> (only present
              for Android phones). Note this is a string containing numeric digits, not an integer.
          * Read-only
      
      - manufacturer
          * Android phone manufacturer (only present for Android phones)
          * Read-only
      
      - model
          * Android phone model (only present for Android phones)
          * Read-only
      
      - send_limit (int)
          * Maximum number of SMS messages per hour that can be sent by this Android phone. To
              increase this limit, install additional SMS expansion packs in the Telerivet app.
              (only present for Android phones)
          * Read-only
*/
public class Phone extends Entity
{
    /**
        Queries messages sent or received by this phone.
    */
    public APICursor<Message> queryMessages(JSONObject options)
    {
        return api.newCursor(Message.class, getBaseApiPath() + "/messages", options);
    }

    public APICursor<Message> queryMessages()
    {
        return queryMessages(null);
    }

    /**
        Saves any fields or custom variables that have changed for this phone.
    */
    @Override
    public void save() throws IOException
    {
        super.save();
    }

    public String getId()
    {
        return (String) get("id");
    }

    public String getName()
    {
        return (String) get("name");
    }

    public void setName(String value)
    {
        set("name", value);
    }

    public String getPhoneNumber()
    {
        return (String) get("phone_number");
    }

    public void setPhoneNumber(String value)
    {
        set("phone_number", value);
    }

    public String getPhoneType()
    {
        return (String) get("phone_type");
    }

    public String getCountry()
    {
        return (String) get("country");
    }

    public Boolean getSendPaused()
    {
        return (Boolean) get("send_paused");
    }

    public void setSendPaused(Boolean value)
    {
        set("send_paused", value);
    }

    public Long getTimeCreated()
    {
        return Util.toLong(get("time_created"));
    }

    public Long getLastActiveTime()
    {
        return Util.toLong(get("last_active_time"));
    }

    public String getProjectId()
    {
        return (String) get("project_id");
    }

    public Integer getBattery()
    {
        return (Integer) get("battery");
    }

    public Boolean getCharging()
    {
        return (Boolean) get("charging");
    }

    public String getAppVersion()
    {
        return (String) get("app_version");
    }

    public Integer getAndroidSdk()
    {
        return (Integer) get("android_sdk");
    }

    public String getMccmnc()
    {
        return (String) get("mccmnc");
    }

    public String getManufacturer()
    {
        return (String) get("manufacturer");
    }

    public String getModel()
    {
        return (String) get("model");
    }

    public Integer getSendLimit()
    {
        return (Integer) get("send_limit");
    }

    @Override
    public String getBaseApiPath()
    {
        return "/projects/" + getProjectId() + "/phones/" + getId() + "";
    }

    public Phone(TelerivetAPI api, JSONObject data)
    {
        this(api, data, true);
    }
    
    public Phone(TelerivetAPI api, JSONObject data, boolean isLoaded)
    {
        super(api, data, isLoaded);
    }
}
