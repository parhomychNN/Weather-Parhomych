
package ru.parhomych.weatherparhomych.city;

import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Country implements Serializable {

    @SerializedName("ID")
    private String iD;
    @SerializedName("LocalizedName")
    private String localizedName;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Country() {
    }

    /**
     * @param localizedName
     * @param iD
     */
    public Country(String iD, String localizedName) {
        super();
        this.iD = iD;
        this.localizedName = localizedName;
    }

    public String getID() {
        return iD;
    }

    public void setID(String iD) {
        this.iD = iD;
    }

    public String getLocalizedName() {
        return localizedName;
    }

    public void setLocalizedName(String localizedName) {
        this.localizedName = localizedName;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("iD", iD)
                .append("localizedName", localizedName)
                .append("additionalProperties", additionalProperties).toString();
    }

}
