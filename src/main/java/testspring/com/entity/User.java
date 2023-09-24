package testspring.com.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import testspring.com.repository.UserRepository;

@Entity
@Table(name = UserRepository.TABLE)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String userName;

	private String email;

	private String password;

	private Boolean isDelete = false;

	private LocalDateTime createDate;

	private LocalDateTime updateDate;

	private String updateBy;

}
