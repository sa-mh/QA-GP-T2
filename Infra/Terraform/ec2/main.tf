resource "aws_instance" "EC2" {
  ami                         = var.ami
  instance_type               = var.type
  key_name                    = "myKey"
  subnet_id                   = var.subnet_id
  vpc_security_group_ids      = var.security_group_ids
  associate_public_ip_address = "true"
  tags                        = var.tag1
}

