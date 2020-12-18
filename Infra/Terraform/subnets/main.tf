resource "aws_subnet" "VPCSub" {
  vpc_id                  = var.vpc_id
  map_public_ip_on_launch = "true"

  for_each = var.AZ_CIDR
  availability_zone = each.key
  cidr_block              = each.value
  
  tags = {
    Name = "FP - Subnet"
    "kubernetes.io/cluster/project_cluster" = "shared"
  }
}

resource "aws_db_subnet_group" "rds_groups" {
  name = "rds_groups"
  subnet_ids = [aws_subnet.VPCSub["eu-west-1a"].id, aws_subnet.VPCSub["eu-west-1b"].id, aws_subnet.VPCSub["eu-west-1c"].id]
}