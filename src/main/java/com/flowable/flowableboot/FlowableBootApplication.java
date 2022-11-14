package com.flowable.flowableboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.flowable.service.MyService;

@SpringBootApplication
@ComponentScan({ "com.flowable.*" })
@EnableJpaRepositories(basePackages = { "com.flowable.*" })
@EntityScan("com.flowable.*")  
public class FlowableBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlowableBootApplication.class, args);
	}

//	@Bean
//    public CommandLineRunner init(final RepositoryService repositoryService,
//                                  final RuntimeService runtimeService,
//                                  final TaskService taskService) {
//
//        return new CommandLineRunner() {
//            @Override
//            public void run(String... strings) throws Exception {
//                System.out.println("Number of process definitions : "
//                    + repositoryService.createProcessDefinitionQuery().count());
//                System.out.println("Number of tasks : " + taskService.createTaskQuery().count());
//                runtimeService.startProcessInstanceByKey("oneTaskProcess");
//                System.out.println("Number of tasks after process start: "
//                    + taskService.createTaskQuery().count());
//            }
//        };
//    }

	@Bean
	public CommandLineRunner init(final MyService myService) {

		return new CommandLineRunner() {
			public void run(String... strings) throws Exception {
				myService.createDemoUsers();
			}
		};
	}

}
