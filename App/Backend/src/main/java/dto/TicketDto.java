package dto;

import java.util.Date;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class TicketDto {

	private Long id;
	private String title;
	private String issue;
	private String topic;
	private Date submitDate;
	private int urgency;
	private String status;
	private int trainerId;
	private int traineeId;
	
	public TicketDto(Long id, String title, String issue, String topic, Date submitDate, int urgency, String status, int trainerId, int traineeId) {
		super();
		this.id = id;
		this.title = title;
		this.issue = issue;
		this.topic = topic;
		this.submitDate = submitDate;
		this.urgency = urgency;
		this.status = status;
		this.trainerId = trainerId;
		this.traineeId = traineeId;
	}
	
	
}
