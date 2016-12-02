DROP SCHEMA IF EXISTS `ecat` ;
CREATE SCHEMA IF NOT EXISTS `ecat` 

CREATE TABLE IF NOT EXISTS `ecat`.`attr_type_defs` (
  `attr_type_def_id` INT(11) NOT NULL AUTO_INCREMENT,
  `attr_type_id` INT(11) NULL DEFAULT NULL,
  `object_type_id` INT(11) NULL DEFAULT NULL,
  `name` VARCHAR(200) NULL DEFAULT NULL,
  PRIMARY KEY (`attr_type_def_id`),
  UNIQUE INDEX `attr_type_def_id_UNIQUE` (`attr_type_def_id` ASC),
  INDEX `attr_type_def_attr_type_id_idx` (`attr_type_id` ASC),
  INDEX `attr_type_def_object_type_id_idx` (`object_type_id` ASC),
  CONSTRAINT `attr_type_def_attr_type_id`
    FOREIGN KEY (`attr_type_id`)
    REFERENCES `ecat`.`attr_types` (`attr_type_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `attr_type_def_object_type_id`
    FOREIGN KEY (`object_type_id`)
    REFERENCES `ecat`.`object_types` (`object_type_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8

CREATE TABLE IF NOT EXISTS `ecat`.`attr_types` (
  `attr_type_id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NULL DEFAULT NULL,
  PRIMARY KEY (`attr_type_id`),
  UNIQUE INDEX `attr_type_id_UNIQUE` (`attr_type_id` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8

CREATE TABLE IF NOT EXISTS `ecat`.`attributes` (
  `attr_id` INT(11) NOT NULL AUTO_INCREMENT,
  `attr_type_id` INT(11) NULL DEFAULT NULL,
  `attr_type_def_id` INT(11) NULL DEFAULT NULL,
  `name` VARCHAR(200) NULL DEFAULT NULL,
  `ismultiple` INT(11) NULL DEFAULT NULL,
  `mask` VARCHAR(1000) NULL DEFAULT NULL,
  `def_value` VARCHAR(1000) NULL DEFAULT NULL,
  `description` VARCHAR(1000) NULL DEFAULT NULL,
  `required` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`attr_id`),
  UNIQUE INDEX `attr_id_UNIQUE` (`attr_id` ASC),
  INDEX `attr_type_id_idx` (`attr_type_id` ASC),
  INDEX `attr_type_def_id_idx` (`attr_type_def_id` ASC),
  CONSTRAINT `attr_type_def_id`
    FOREIGN KEY (`attr_type_def_id`)
    REFERENCES `ecat`.`attr_type_defs` (`attr_type_def_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `attr_type_id`
    FOREIGN KEY (`attr_type_id`)
    REFERENCES `ecat`.`attr_types` (`attr_type_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8

CREATE TABLE IF NOT EXISTS `ecat`.`categories` (
  `category_id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NULL DEFAULT NULL,
  `description` VARCHAR(2000) NULL DEFAULT NULL,
  PRIMARY KEY (`category_id`),
  UNIQUE INDEX `category_id_UNIQUE` (`category_id` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8

CREATE TABLE IF NOT EXISTS `ecat`.`list_values` (
  `list_values_id` INT(11) NOT NULL AUTO_INCREMENT,
  `attr_type_def_id` INT(11) NULL DEFAULT NULL,
  `value` VARCHAR(1000) NULL DEFAULT NULL,
  PRIMARY KEY (`list_values_id`),
  UNIQUE INDEX `list_values_id_UNIQUE` (`list_values_id` ASC),
  INDEX `list_values_attr_type_def_id_idx` (`attr_type_def_id` ASC),
  CONSTRAINT `list_values_attr_type_def_id`
    FOREIGN KEY (`attr_type_def_id`)
    REFERENCES `ecat`.`attr_type_defs` (`attr_type_def_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8

CREATE TABLE IF NOT EXISTS `ecat`.`object_types` (
  `object_type_id` INT(11) NOT NULL AUTO_INCREMENT,
  `parent_id` INT(11) NULL DEFAULT NULL,
  `picture_id` INT(11) NULL DEFAULT NULL,
  `name` VARCHAR(200) NULL DEFAULT NULL,
  `description` VARCHAR(1000) NULL DEFAULT NULL,
  PRIMARY KEY (`object_type_id`),
  UNIQUE INDEX `object_type_id_UNIQUE` (`object_type_id` ASC),
  INDEX `parent_id_idx` (`parent_id` ASC),
  INDEX `object_type_picture_id_idx` (`picture_id` ASC),
  CONSTRAINT `object_type_parent_id`
    FOREIGN KEY (`parent_id`)
    REFERENCES `ecat`.`object_types` (`object_type_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `object_type_picture_id`
    FOREIGN KEY (`picture_id`)
    REFERENCES `ecat`.`pictures` (`picture_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8

CREATE TABLE IF NOT EXISTS `ecat`.`objects` (
  `object_id` INT(11) NOT NULL,
  `object_parent_id` INT(11) NULL DEFAULT NULL,
  `object_type_id` INT(11) NULL DEFAULT NULL,
  `picture_id` INT(11) NULL DEFAULT NULL,
  `name` VARCHAR(200) NULL DEFAULT NULL,
  `description` VARCHAR(1000) NULL DEFAULT NULL,
  PRIMARY KEY (`object_id`),
  UNIQUE INDEX `objects_id_UNIQUE` (`object_id` ASC),
  INDEX `parent_id_idx` (`object_parent_id` ASC),
  INDEX `object_type_id_idx` (`object_type_id` ASC),
  INDEX `picture_id_idx` (`picture_id` ASC),
  CONSTRAINT `object_type_id`
    FOREIGN KEY (`object_type_id`)
    REFERENCES `ecat`.`object_types` (`object_type_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `parent_id`
    FOREIGN KEY (`object_parent_id`)
    REFERENCES `ecat`.`objects` (`object_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `picture_id`
    FOREIGN KEY (`picture_id`)
    REFERENCES `ecat`.`pictures` (`picture_id`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8

CREATE TABLE IF NOT EXISTS `ecat`.`params` (
  `attr_id` INT(11) NOT NULL,
  `object_id` INT(11) NOT NULL,
  `value` VARCHAR(1000) NULL DEFAULT NULL,
  `data` BLOB NULL DEFAULT NULL,
  `list_value_id` INT(11) NULL DEFAULT NULL,
  `date_value` DATE NULL DEFAULT NULL,
  INDEX `param_attr_id_idx` (`attr_id` ASC),
  INDEX `list_value_id_idx` (`list_value_id` ASC),
  CONSTRAINT `params_attr_id`
    FOREIGN KEY (`attr_id`)
    REFERENCES `ecat`.`attributes` (`attr_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `params_list_value_id`
    FOREIGN KEY (`list_value_id`)
    REFERENCES `ecat`.`list_values` (`list_values_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8

CREATE TABLE IF NOT EXISTS `ecat`.`pictures` (
  `picture_id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NULL DEFAULT NULL,
  `url` VARCHAR(1000) NULL DEFAULT NULL,
  `width` INT(11) NULL DEFAULT NULL,
  `height` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`picture_id`),
  UNIQUE INDEX `picture_id_UNIQUE` (`picture_id` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8

CREATE TABLE IF NOT EXISTS `ecat`.`products` (
  `product_id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NULL DEFAULT NULL,
  `description` VARCHAR(2000) NULL DEFAULT NULL,
  `stock` INT(11) NULL DEFAULT NULL,
  `price` INT(11) NULL DEFAULT NULL,
  `category_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  UNIQUE INDEX `product_id_UNIQUE` (`product_id` ASC),
  INDEX `category_id_idx` (`category_id` ASC),
  CONSTRAINT `category_id`
    FOREIGN KEY (`category_id`)
    REFERENCES `ecat`.`categories` (`category_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8

CREATE TABLE IF NOT EXISTS `ecat`.`references` (
  `object_id` INT(11) NOT NULL,
  `reference` INT(11) NOT NULL,
  `attr_id` INT(11) NOT NULL,
  INDEX `reference_object_id_idx` (`object_id` ASC),
  INDEX `reference_id_idx` (`reference` ASC),
  INDEX `reference_attr_id_idx` (`attr_id` ASC),
  CONSTRAINT `reference_attr_id`
    FOREIGN KEY (`attr_id`)
    REFERENCES `ecat`.`attributes` (`attr_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `reference_object_id`
    FOREIGN KEY (`object_id`)
    REFERENCES `ecat`.`objects` (`object_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `reference_reference_id`
    FOREIGN KEY (`reference`)
    REFERENCES `ecat`.`objects` (`object_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8

CREATE TABLE IF NOT EXISTS `ecat`.`users` (
  `user_id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NULL DEFAULT NULL,
  `email` VARCHAR(200) NULL DEFAULT NULL,
  `address` VARCHAR(200) NULL DEFAULT NULL,
  `password` VARCHAR(200) NULL DEFAULT NULL,
  `confirmPassword` VARCHAR(200) NULL DEFAULT NULL,
  `sex` VARCHAR(200) NULL DEFAULT NULL,
  `grants` VARCHAR(200) NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `user_id_UNIQUE` (`user_id` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8
