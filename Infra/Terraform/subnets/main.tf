resource "aws_subnet" "taskVPCSubnet" {
  vpc_id                  = var.vpc_id
  cidr_block              = "10.0.1.0/24"
  map_public_ip_on_launch = "true"
  availability_zone = "eu-west-1a"

  tags = {
    Name = "Task-Pub-Sub"
    "kubernetes.io/cluster/project_cluster" = "shared"
  }
}
resource "aws_subnet" "rdsSubnet2" {
  vpc_id                  = var.vpc_id
  cidr_block              = "10.0.3.0/24"
  map_public_ip_on_launch = "true"
  availability_zone = "eu-west-1b"

  tags = {
    Name = "RDS-Pub-Sub-2"
    "kubernetes.io/cluster/project_cluster" = "shared"
  }
}
resource "aws_subnet" "rdsSubnet3" {
  vpc_id                  = var.vpc_id
  cidr_block              = "10.0.4.0/24"
  map_public_ip_on_launch = "true"
  availability_zone = "eu-west-1c"

  tags = {
    Name = "RDS-Pub-Sub-3"
    "kubernetes.io/cluster/project_cluster" = "shared"
  }
  
}
resource "aws_db_subnet_group" "rds_groups" {
  name = "rds_groups"
  subnet_ids = [aws_subnet.taskVPCSubnet.id, aws_subnet.rdsSubnet2.id, aws_subnet.rdsSubnet3.id]
}