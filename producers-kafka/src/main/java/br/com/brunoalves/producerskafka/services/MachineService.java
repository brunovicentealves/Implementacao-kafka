package br.com.brunoalves.producerskafka.services;

import java.util.function.BiConsumer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import models.CreateMachineRequest;
import models.MachineEventDTO;

@Service
@RequiredArgsConstructor
@Log4j2
public class MachineService {
	
	public final KafkaTemplate<String,Object> kafkaTemplate;
	
	
	public void createEvent(CreateMachineRequest request) {
		kafkaTemplate.send("topic-"+request.machineId(),new MachineEventDTO(request))
		.whenComplete(getResultSendMessage());
	}


	private BiConsumer<? super SendResult<String, Object>, ? super Throwable> getResultSendMessage() {
		return (success,ex)->{
			if(ex != null) {
				log.error("::: MACHINE_SERVICE | ERROR SEND MESSAGE :::");
			}else {
				log.info("::: MACHINE_SERVICE | SUCCESSFULY SEND MESSAGE :::");
			}
		};
	}

}
