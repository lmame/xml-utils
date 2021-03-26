package com.example.bundle;

import com.bmc.arsys.rx.services.action.domain.Action;
import com.bmc.arsys.rx.services.action.domain.ActionParameter;
import com.bmc.arsys.rx.services.common.Service;
import com.bmc.arsys.rx.services.common.domain.Scope;
import com.bmc.arsys.rx.services.record.domain.Attachment;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import javax.validation.constraints.NotNull;
import java.nio.charset.StandardCharsets;

public class XmlUtils  implements Service {


    @Action(name = "XmlAttachmentToJson", scope = Scope.PUBLIC)
    public String XmlAttachmentToJson(@ActionParameter(name = "xmlAttachment") @NotNull Attachment xmlAttachment,
                                          @ActionParameter(name = "maxIndentation") int maxIndentation) {
        String xmlText = "";
        String jsonString = "";
        int indentation = maxIndentation > 0 ? maxIndentation : 4;

        if (xmlAttachment != null) {
            xmlText = new String(xmlAttachment.getBinaryData(), StandardCharsets.UTF_8);

            // Trying to convert from Xml to Json
            try {
                JSONObject xmlJSONObj = XML.toJSONObject(xmlText);
                jsonString = xmlJSONObj.toString(indentation);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return jsonString;
    }
}
