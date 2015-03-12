CREATE  TABLE `cs`.`second_goods` (
  `id` INT NOT NULL ,
  `category` VARCHAR(45) NULL ,
  `type` VARCHAR(45) NULL ,
  `title` VARCHAR(100) NULL ,
  `imagePath` VARCHAR(45) NULL ,
  `desc` VARCHAR(100) NULL ,
  `owner` VARCHAR(45) NULL ,
  `phone` VARCHAR(45) NULL ,
  PRIMARY KEY (`id`) );

CREATE  TABLE `cs`.`user_publish_goods` (
  `userID` INT NOT NULL ,
  `goodsID` INT NOT NULL ,
  `stage` VARCHAR(45) NULL ,
  PRIMARY KEY (`userID`, `goodsID`) );
  
CREATE  TABLE `cs`.`user_love_goods` (
  `userID` INT NOT NULL ,
  `goodsID` INT NOT NULL ,
  `stage` VARCHAR(45) NULL ,
  PRIMARY KEY (`userID`, `goodsID`) );