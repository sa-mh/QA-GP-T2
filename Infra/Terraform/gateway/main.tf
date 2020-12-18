resource "aws_internet_gateway" "taskGateway" {
  vpc_id = var.vpc_id

  tags = {
    Name = "Task-Gateway"
  }
}