resource "aws_route_table" "taskTable" {
  vpc_id       = var.vpc_id
  
  route {
    cidr_block = "0.0.0.0/0"
    gateway_id = var.gateway_id
  }

  tags = {
    Name = "Task-Route-Internet-Subnet"
  }
}

resource "aws_route_table_association" "taskRouteAsso" {

  for_each = var.subnetid
  subnet_id      = each.value
  route_table_id = aws_route_table.taskTable.id
}
