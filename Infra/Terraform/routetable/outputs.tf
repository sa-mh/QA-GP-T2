output "routetable_id" {
  value = aws_route_table.taskTable.id
}

output "routetable_asso_id" {
  value = aws_route_table_association.taskRouteAsso["subnet1"].id
}