resource "aws_route_table" "taskTable" {
  vpc_id = var.vpc_id
  route {
    cidr_block = "0.0.0.0/0"
    gateway_id = var.gateway_id
  }
  tags = {
    Name = "Task-Route-Internet-Subnet"
  }
}

resource "aws_route_table_association" "taskRouteAsso" {
  subnet_id      = var.subnet_id
  route_table_id = aws_route_table.taskTable.id
}
resource "aws_route_table_association" "Route2Asso" {
  subnet_id      = var.subnet2_id
  route_table_id = aws_route_table.taskTable.id
}
resource "aws_route_table_association" "Route3Asso" {
  subnet_id      = var.subnet3_id
  route_table_id = aws_route_table.taskTable.id
}