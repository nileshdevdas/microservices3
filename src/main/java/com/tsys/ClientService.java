package com.tsys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ClientService {
	@Autowired
	DiscoveryClient client;
	//
	@Autowired
	LoadBalancerClient lbclient;

	@RequestMapping(path = "lb", method = RequestMethod.GET)
	public void testLB() {

		ServiceInstance instance = lbclient.choose("EMPAPP");
		ResponseEntity<Employee> result = new RestTemplate()
				.getForEntity("http://" + instance.getHost() + ":" + instance.getPort() + "/employee", Employee.class);
		System.out.println("-----------------------------------------");
			System.out.println("Now Serving from " + instance.getPort());
		// Employee emp = result.getBody();
//		System.out.println(emp.getId());
//		System.out.println(emp.getName());
//		client.getInstances("EMPAPP").forEach(service -> {
//			System.out.println(service.getHost());
//			System.out.println(service.getPort());
//		});
		System.out.println("-----------------------------------------");

	}
}
