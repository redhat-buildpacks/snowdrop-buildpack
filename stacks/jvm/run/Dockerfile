ARG base_image
FROM ${base_image}

# Set required CNB information
ARG stack_id

ENV CNB_STACK_ID=${stack_id}
ENV CNB_USER_ID=185
ENV CNB_GROUP_ID=185

LABEL io.buildpacks.stack.id="${stack_id}"
