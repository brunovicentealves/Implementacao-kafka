package br.com.brunoalves.consumerskafka.listeners;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import lombok.extern.log4j.Log4j2;
import models.MachineEventDTO;

@Log4j2
@Component
public class MachineListener {

	@KafkaListener(
					topics = "topic-1",
					groupId = "machine-one",
					containerFactory = "containerFactory")
	public void  machineOneListener(@Payload MachineEventDTO dto) {
		
		log.info("::: MACHINE_LISTENER | MACHINE_ONE_LISTENER RECEIVED MESSAGE 1, Payload {} :::",dto.toString());
	}
	
	@KafkaListener(
					topics = "topic-1",
					groupId = "machine-one",
					containerFactory = "containerFactory")
	public void  machineOneListenerTwo(@Payload MachineEventDTO dto) {
		
		log.info("::: MACHINE_LISTENER | MACHINE_ONE_LISTENER RECEIVED MESSAGE 2, Payload {} :::",dto.toString());
	}
}
