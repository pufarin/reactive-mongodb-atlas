package space.unbound.callback.entity;

import java.sql.Timestamp;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Document
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseData {

    @Id
    private String uuid;

    private String call_back;

    private Timestamp timeStamp;

    private String eventName;

    private String parameter;

}




