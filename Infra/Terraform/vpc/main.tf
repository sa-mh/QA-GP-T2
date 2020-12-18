resource "aws_vpc" "taskVPC" {
  cidr_block = "10.0.0.0/16"
  
  tags = {
    Name = "task-VPC"
  }
}