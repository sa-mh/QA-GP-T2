resource "aws_security_group" "taskSSH" {
  vpc_id = var.vpc_id

  dynamic "ingress" {
    iterator = port
    for_each = var.ports
    content {
      from_port   = port.key
      to_port     = port.value
      protocol    = "tcp"
      cidr_blocks = ["0.0.0.0/0", var.vpccidr]
    }
  }

  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }

  tags = {
    Name = "SSH-SG"
  }
}

