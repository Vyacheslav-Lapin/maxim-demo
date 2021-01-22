package ru.vlapin.demo.maximdemo.model;

import static lombok.AccessLevel.PRIVATE;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Entity
@Builder
@AllArgsConstructor(access = PRIVATE)
@Setter(PRIVATE)
@NoArgsConstructor
@RequiredArgsConstructor
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, doNotUseGetters = true)
public class Cat {

  @Id
  @Include
  @Default
  @GeneratedValue
  @Column(updatable = false, nullable = false)
  UUID id = UUID.randomUUID();

  @Default
  @Version
  int version = 0;

  @NonNull
  @Default
  String name = "Мурка";
}
